package com.piryth.shapemonitorapi.appUser;

import jakarta.annotation.Nullable;
public record AppUserDto(String username, String email, String password, float height, String gender) {

}
