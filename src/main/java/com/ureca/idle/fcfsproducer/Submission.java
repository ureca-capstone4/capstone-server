package com.ureca.idle.fcfsproducer;

import java.time.LocalDate;

public record Submission(LocalDate timeStamp, Long id, String name, String phoneNum)  {
}
