package exam.domain.models.service;

import javax.validation.constraints.NotNull;

public class DocumentServiceModel {

    private String id;
    private String title;
    private String content;

    public DocumentServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @NotNull(message = "can not be empty!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @NotNull(message = "can not be empty!")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
