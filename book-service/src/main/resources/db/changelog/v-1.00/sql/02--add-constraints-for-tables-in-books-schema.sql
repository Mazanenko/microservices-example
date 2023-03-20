ALTER TABLE IF EXISTS books.books
    ADD CONSTRAINT books_uk_author_name UNIQUE (author_id, name),
    ADD CONSTRAINT books_fk_author FOREIGN KEY (author_id) REFERENCES books.authors (id) ON DELETE SET NULL;