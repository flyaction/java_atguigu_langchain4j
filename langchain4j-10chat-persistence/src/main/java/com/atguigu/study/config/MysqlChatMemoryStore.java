package com.atguigu.study.config;

import com.atguigu.study.entity.ChatMemory;
import com.atguigu.study.mapper.ChatMemoryMapper;
import com.atguigu.study.service.ChatMemoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @auther zzyybs@126.com
 * @Date 2025-05-04 16:38
 * @Description: https://docs.langchain4j.dev/tutorials/chat-memory#persistence
 */
@Component
public class MysqlChatMemoryStore implements ChatMemoryStore
{

    @Autowired
    private ChatMemoryMapper chatMemoryMapper;

    @Autowired
    private ChatMemoryService chatMemoryService;


    @Override
    public List<ChatMessage> getMessages(Object memoryId) {

        QueryWrapper<ChatMemory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("memory_id", memoryId.toString());

        ChatMemory entity = chatMemoryMapper.selectOne(queryWrapper);
        if (entity != null && entity.getMessageJson() != null) {
            return ChatMessageDeserializer.messagesFromJson(entity.getMessageJson());
        }
        return Collections.emptyList(); // 返回空列表而不是null
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {

        String json = ChatMessageSerializer.messagesToJson(messages);

        QueryWrapper<ChatMemory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("memory_id", memoryId.toString());
        ChatMemory existingEntity = chatMemoryMapper.selectOne(queryWrapper);

        ChatMemory entity = new ChatMemory();
        entity.setMemoryId(memoryId.toString());
        entity.setMessageJson(json);

        if (existingEntity != null) {
            // 如果存在则更新
            entity.setId(existingEntity.getId()); // 设置主键ID
            chatMemoryMapper.updateById(entity);
        } else {
            // 如果不存在则插入
            chatMemoryMapper.insert(entity);
        }

    }

    @Override
    public void deleteMessages(Object memoryId) {
        QueryWrapper<ChatMemory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("memory_id", memoryId.toString());
        chatMemoryMapper.delete(queryWrapper);
    }
}
