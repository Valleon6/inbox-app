package com.valleon.inboxapp.controllers;

import com.valleon.inboxapp.emailList.EmailListItemRepository;
import com.valleon.inboxapp.folders.Folder;
import com.valleon.inboxapp.folders.FolderRepository;
import com.valleon.inboxapp.folders.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InboxController {

    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FolderService folderService;
    @Autowired
    private EmailListItemRepository emailListItemRepository;

    @GetMapping(value = "/")
    private String homePage(@AuthenticationPrincipal OAuth2User principal, Model model) {

        if (principal == null || StringUtils.hasText(principal.getAttribute("login"))) {
            return "index";
        }
        {
            String userId = principal.getAttribute("login");

            //Fetch folders
            List<Folder> userFolders = folderRepository.findAllById(userId);
            model.addAttribute("userFolders", userFolders);
            List<Folder> defaultFolders = folderService.fetchDefaultFolder(userId);
            model.addAttribute("defaultFolders", defaultFolders);

            //Fetch messages

            return "inbox-app";
        }
    }

}
