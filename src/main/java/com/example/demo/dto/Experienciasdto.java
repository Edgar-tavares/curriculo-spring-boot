package com.example.demo.dto;

import java.time.LocalDateTime;

import io.micrometer.common.lang.Nullable;

public record Experienciasdto(String enterprise, String summary, LocalDateTime start, @Nullable LocalDateTime end) {
}
