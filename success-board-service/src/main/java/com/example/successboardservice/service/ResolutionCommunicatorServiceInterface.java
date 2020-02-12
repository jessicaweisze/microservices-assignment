package com.example.successboardservice.service;

import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.ResolutionUser;
import com.example.successboardservice.web.model.UserResolutionItem;

import java.util.List;

public interface ResolutionCommunicatorServiceInterface {

    public List<ResolutionItem> findAllResolutions();

    public List<ResolutionItem> findResolutionsByUser(Integer userId);

    public List<UserResolutionItem> getUserResolutions();

    public ResolutionItem saveResolutionItem(ResolutionItem resolutionItem);

    public List<ResolutionUser> findAllUser();

    public ResolutionUser saveUser(ResolutionUser resolutionUser);

    public ResolutionUser deleteUser(Integer userId);

    public ResolutionItem get(Integer itemId);

    public ResolutionItem deleteResolutionItem(Integer itemId);
}
