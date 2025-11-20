package com.atguigu.study.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.study.service.ChatMysqlPersistenceAssistant;
import com.atguigu.study.service.ChatPersistenceAssistant;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyybs@126.com
 * @Date 2025-06-02 16:11
 * @Description: TODO
 */
@RestController
@Slf4j
public class ChatPersistenceController
{
    @Resource
    private ChatPersistenceAssistant chatPersistenceAssistant;

    @Resource
    private ChatMysqlPersistenceAssistant chatMysqlPersistenceAssistant;

    // http://localhost:9010/chatpersistence/redis
    @GetMapping(value = "/chatpersistence/redis")
    public String testChatPersistence()
    {
        chatPersistenceAssistant.chat(1L, "你好！我的名字是redis");
        chatPersistenceAssistant.chat(2L, "你好！我的名字是nacos");

        String chat = chatPersistenceAssistant.chat(1L, "我的名字是什么");
        System.out.println(chat);

        chat = chatPersistenceAssistant.chat(2L, "我的名字是什么");
        System.out.println(chat);

        return "testChatPersistence success : "+ DateUtil.now();
    }

    // http://localhost:9010/chatpersistence/mysql
    @GetMapping(value = "/chatpersistence/mysql")
    public String testChatPersistence2()
    {
        chatMysqlPersistenceAssistant.chat("action", "你好！我的名字是mysql");
        chatMysqlPersistenceAssistant.chat("xxdd", "你好！我的名字是oracle");

        String chat = chatMysqlPersistenceAssistant.chat("action", "我的名字是什么");
        System.out.println(chat);

        chat = chatMysqlPersistenceAssistant.chat("xxdd", "我的名字是什么");
        System.out.println(chat);

        return "testChatPersistence success : "+ DateUtil.now();
    }

}
