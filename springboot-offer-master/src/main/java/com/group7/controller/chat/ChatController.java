package com.group7.controller.chat;

import cn.hutool.core.bean.BeanUtil;
import com.group7.db.jpa.Chat;
import com.group7.db.jpa.ChatRepository;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.entitiy.UserVo;
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

    @Resource
    UserRepository userRepository;

    @GetMapping("/getList/{name}")
    public R getListAsReceiver(@PathVariable("name") String name) {
        List<Chat> list = chatRepository.findAllByReceiver(name);
        List<Chat> list2 = chatRepository.findAllBySender(name);
        list.addAll(list2);
//        System.out.println("==========666");
//        System.out.println(list);
//        System.out.println("==========666");
        return R.ok().data("chatList", list);
    }

    @GetMapping("getChatInfo/{id}")
    public R getChatInfo(@PathVariable("id") Long id){
        Chat chat = chatRepository.getOne(id);
        List<Chat> list = chatRepository.findAllBySenderIdAndReceiverId(chat.getSenderId(), chat.getReceiverId());
        List<Chat> list_Extra = chatRepository.findAllBySenderIdAndReceiverId(chat.getReceiverId(), chat.getSenderId());
        list.addAll(list_Extra);
//        System.out.println("==========666");
//        System.out.println(list);
//        System.out.println("==========666");
        return R.ok().data("list", list);
    }

    @GetMapping("getInfo/{name}/{id}")
    public R getInfo(@PathVariable("name") String name, @PathVariable("id") Long id){
        Chat chat = chatRepository.getOne(id);
        String sender = chat.getSender();
        User user1 = userRepository.getById(chat.getSenderId());
        User user2 = userRepository.getById(chat.getReceiverId());
        UserVo senderInfo = null;
        UserVo receiverInfo = null;
        if (sender.equals(name)){
            BeanUtil.copyProperties(user1, senderInfo);
            BeanUtil.copyProperties(user2, receiverInfo);
        }else{
            BeanUtil.copyProperties(user2, senderInfo);
            BeanUtil.copyProperties(user1, receiverInfo);
        }
        System.out.println(senderInfo);
        System.out.println(receiverInfo);
        System.out.println("-=-=-=-=-=-=-=-=-=-=888");
        return R.ok().data("senderInfo", senderInfo).data("receiverInfo", receiverInfo);
    }
}
