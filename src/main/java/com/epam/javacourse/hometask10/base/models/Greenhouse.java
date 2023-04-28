package com.epam.javacourse.hometask10.base.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Greenhouse {
    @NonNull
    int id;
    String name;
    int gardenerId;
}
