package com.audio.stream.media.audiostreamingmedia.service;

public interface RoleService<T> extends IService<T> {

    T findByName(String name);
}
