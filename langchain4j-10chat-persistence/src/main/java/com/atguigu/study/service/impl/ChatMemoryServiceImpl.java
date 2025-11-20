package com.atguigu.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.study.entity.ChatMemory;
import com.atguigu.study.service.ChatMemoryService;
import com.atguigu.study.mapper.ChatMemoryMapper;
import org.springframework.stereotype.Service;

/**
* @author action
* @description 针对表【chat_memory(聊天记忆存储表)】的数据库操作Service实现
* @createDate 2025-11-20 10:03:37
*/
@Service
public class ChatMemoryServiceImpl extends ServiceImpl<ChatMemoryMapper, ChatMemory>
    implements ChatMemoryService{

}




