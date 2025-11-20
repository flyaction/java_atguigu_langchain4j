package com.atguigu.study.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 聊天记忆存储表
 * @TableName chat_memory
 */
@TableName(value ="chat_memory")
@Data
public class ChatMemory {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("memory_id") // 映射字段名
    private String memoryId;

    @TableField("message_json")
    private String messageJson;

    @TableField(value = "created_at", fill = FieldFill.INSERT) // 插入时填充
    private LocalDateTime createdAt;

    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充
    private LocalDateTime updatedAt;

}