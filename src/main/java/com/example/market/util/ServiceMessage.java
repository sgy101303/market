package com.example.market.util;


import kr.sharenshare.keylitadmin.domain.member.AdminDto;

public class ServiceMessage extends DataMessage {


    public ServiceMessage setLoginMember(AdminDto user) {
        addData("loginMember", user);
        return this;
    }

    public AdminDto getLoginMember() {
        return getObject("loginMember", AdminDto.class);
    }

    public boolean isAdmin() {
        AdminDto loginMember = getObject("loginMember", AdminDto.class);
        return loginMember.getCpIdx().equals("sharenshare");
    }

    @Override
    public ServiceMessage addData(String key, Object object) {
        super.addData(key, object);
        return this;
    }

    public ServiceMessage setResult(Object object) {
        put("result", object);
        return this;
    }

    public Object getResult() {
        return get("result");
    }

}
