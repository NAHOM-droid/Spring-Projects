package com.NHTech.Book.Store.KafkaSetting;

import com.NHTech.Book.Store.BookApplication.BookAPI.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaBook {
    private Book book;
    private String Operation;
}
