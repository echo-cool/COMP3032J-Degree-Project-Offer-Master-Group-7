package com.group7.controller.chat;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;

import com.group7.db.jpa.Chat;
import com.group7.db.jpa.ChatRepository;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.entitiy.ChatDto;
import com.group7.entitiy.ChatFrontDto;
import com.group7.entitiy.UserVo;
import com.group7.utils.common.R;
import com.group7.websocket.WebSocketServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Resource
    ChatRepository chatRepository;

    @Resource
    UserRepository userRepository;

    @GetMapping("/getList/{name}")
    public R getList(@PathVariable("name") String name) {
        List<Chat> list = chatRepository.findAllByReceiver(name);
        List<Chat> list2 = chatRepository.findAllBySender(name);
        list.addAll(list2);
        Map<String, Chat> map = new HashMap<>();
        for (Chat chat : list) {
            map.put(chat.getSender() + "|" + chat.getReceiver(), chat);
        }
        System.out.println(list);
        System.out.println("---===---999");

        return R.ok().data("chatList", map.values());
    }

    @GetMapping("getChatInfo/{id}")
    public R getChatInfo(@PathVariable("id") Long id){
        Chat chat = chatRepository.getOne(id);
        List<Chat> list = chatRepository.findAllBySenderIdAndReceiverId(chat.getSenderId(), chat.getReceiverId());
        List<Chat> list_Extra = chatRepository.findAllBySenderIdAndReceiverId(chat.getReceiverId(), chat.getSenderId());
        list.addAll(list_Extra);

        Comparator<Chat> tmpComparator = new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        };
        Collections.sort(list,tmpComparator);
//        System.out.println("==========666");
//        System.out.println(list);
//        System.out.println("==========666");
        return R.ok().data("list", list);
    }

    @GetMapping("getChatInfoById/{id1}/{id2}")
    public R getChatInfoById(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){
        List<Chat> list = chatRepository.findAllBySenderIdAndReceiverId(id1, id2);
        List<Chat> list_Extra = chatRepository.findAllBySenderIdAndReceiverId(id2, id1);
        list.addAll(list_Extra);
        Comparator<Chat> tmpComparator = new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        };
        Collections.sort(list,tmpComparator);
        System.out.println("==========666");
        System.out.println(list);
        System.out.println("==========666");
        return R.ok().data("list", list);
    }

    @GetMapping("getInfo/{name}/{id}")
    public R getInfo(@PathVariable("name") String name, @PathVariable("id") Long id){
        Chat chat = chatRepository.getOne(id);
        String sender = chat.getSender();
        User user1 = userRepository.getById(chat.getSenderId());
        User user2 = userRepository.getById(chat.getReceiverId());
        UserVo senderInfo = new UserVo();
        UserVo receiverInfo = new UserVo();
        System.out.println(user1.getUsername());
        System.out.println(user2.getUsername());
        if (sender.equals(name)){
            senderInfo.setId(user1.getId());
            senderInfo.setUsername(user1.getUsername());
            senderInfo.setAvatar(user1.getAvatar());
            receiverInfo.setId(user2.getId());
            receiverInfo.setUsername(user2.getUsername());
            receiverInfo.setAvatar(user2.getAvatar());
        }else{
            senderInfo.setId(user2.getId());
            senderInfo.setUsername(user2.getUsername());
            senderInfo.setAvatar(user2.getAvatar());
            receiverInfo.setId(user1.getId());
            receiverInfo.setUsername(user1.getUsername());
            receiverInfo.setAvatar(user1.getAvatar());
        }
        System.out.println(senderInfo);
        System.out.println(receiverInfo);
        System.out.println("-=-=-=-=-=-=-=-=-=-=888");
        return R.ok().data("senderInfo", senderInfo).data("receiverInfo", receiverInfo);
    }

    @GetMapping("getInfoById/{id1}/{id2}")
    public R getInfoById(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){
        List<Chat> list = chatRepository.findAllBySenderIdAndReceiverId(id1, id2);
        List<Chat> list_Extra = chatRepository.findAllBySenderIdAndReceiverId(id2, id1);
        list.addAll(list_Extra);
        Comparator<Chat> tmpComparator = new Comparator<Chat>() {
            @Override
            public int compare(Chat o1, Chat o2) {
                return o1.getCreatedAt().compareTo(o2.getCreatedAt());
            }
        };
        Collections.sort(list,tmpComparator);
        List<ChatFrontDto> fList = new ArrayList<>();
        for (Chat chat : list) {
            ChatFrontDto tmp = new ChatFrontDto();
            tmp.setType("text");
            tmp.setAuthor(chat.getId());
            tmp.setContent(chat.getContent());
            fList.add(tmp);
        }
        return R.ok().data("list", fList);
    }

    @PostMapping("sendChat")
    public R sendChat(@RequestBody ChatDto chatDto){
        Chat chat = new Chat();
        System.out.println(chatDto);
        chat.setContent(chatDto.getContent());
        chat.setSender(chatDto.getSender());
        chat.setReceiver(chatDto.getReceiver());
        chat.setReceiverId(chatDto.getReceiverId());
        chat.setSenderId(chatDto.getSenderId());
        chatRepository.save(chat);
        System.out.println("onlineNumber: " + WebSocketServer.onlineNumber);
        return R.ok();
    }

    @GetMapping("getReceiverInfo/{id}")
    public R getReceiverInfo(@PathVariable("id") Long id){
        User user1 = userRepository.getById(id);
        UserVo Info = new UserVo();
        Info.setId(user1.getId());
        Info.setUsername(user1.getUsername());
        Info.setAvatar(user1.getAvatar());
        System.out.println(Info);
        System.out.println("-=-=-=-=-=-=-=-=-=-=888");
        return R.ok().data("receiverInfo", Info);
    }
}
