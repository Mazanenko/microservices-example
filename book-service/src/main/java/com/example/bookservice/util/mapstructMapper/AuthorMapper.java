package com.example.bookservice.util.mapstructMapper;


import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.resourceserver.openapi.model.AuthorDto;
import com.example.resourceserver.openapi.model.AuthorInputDto;
import com.example.resourceserver.openapi.model.BookDtoAttached;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper {

    @Named("authorToDto")
    @Mapping(target = "books", qualifiedByName = "attachedBookToDto")
    AuthorDto authorToDto(Author author);

    @Named("authorDtoToEntity")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author authorDtoToEntity(AuthorInputDto authorInputDto);

    @Named("updateAuthorFromDto")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "books", ignore = true)
    void updateAuthorFromDto(AuthorInputDto authorInputDto, @MappingTarget Author authorForUpdate);

    @Named("attachedBookToDto")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    BookDtoAttached attachedBookToDto(Book book);
}
