package business.dto;

import persistence.entitites.Section;

public class BookDTO {
    private int id;
    private String title;
    private int volumNumber;
    private String gender;
    private boolean borrowed;
    private boolean freeBook;
    private AuthorDTO authorDTO;
    private SectionDTO sectionDTO;

    public BookDTO() {
    }

    public BookDTO(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
    }

    public BookDTO(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook, AuthorDTO authorDTO, SectionDTO sectionDTO) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
        this.authorDTO = authorDTO;
        this.sectionDTO = sectionDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolumNumber() {
        return volumNumber;
    }

    public void setVolumNumber(int volumNumber) {
        this.volumNumber = volumNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public boolean isFreeBook() {
        return freeBook;
    }

    public void setFreeBook(boolean freeBook) {
        this.freeBook = freeBook;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public SectionDTO getSectionDTO() {
        return sectionDTO;
    }

    public void setSectionDTO(SectionDTO sectionDTO) {
        this.sectionDTO = sectionDTO;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                '}';
    }
}
