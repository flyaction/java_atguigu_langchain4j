package com.atguigu.study.mapper;

import com.atguigu.study.entity.ChatMemory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author action
* @description 针对表【chat_memory(聊天记忆存储表)】的数据库操作Mapper
* @createDate 2025-11-20 10:03:37
* @Entity com.atguigu.study.entity.ChatMemory
*/
@Mapper
public interface ChatMemoryMapper extends BaseMapper<ChatMemory> {

}




