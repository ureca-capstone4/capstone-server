package com.ureca.idle.idleaiclient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookMbtiReq {
    String title;
    String summary;
    String story;
}
