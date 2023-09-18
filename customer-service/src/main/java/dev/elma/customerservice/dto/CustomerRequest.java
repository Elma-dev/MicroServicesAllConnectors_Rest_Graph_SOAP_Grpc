package dev.elma.customerservice.dto;

import lombok.Builder;

@Builder
public record CustomerRequest(String name,String email) {
}
