package com.group7.controller.chat;

import com.group7.db.jpa.Chat;
import com.group7.db.jpa.ChatRepository;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Resource
    ChatRepository chatRepository;

    @GetMapping("/getList/{name}")
    public R getListAsReceiver(@PathVariable("name") String name) {
        List<Chat> list = chatRepository.findAllByReceiver(name);
        List<Chat> list2 = chatRepository.findAllBySender(name);
        list.addAll(list2);
        System.out.println("==========666");
        System.out.println(list);
        System.out.println("==========666");
        return R.ok().data("chatList", list);
    }

}
