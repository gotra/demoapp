package io.github.grajeev.demoapp.model;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("Message")
public  class Message {


    @org.springframework.data.annotation.Id
    private String Id;
    private  String text;
    private  String languageCode;

    public Message() {
    }

    public Message(String id, String text, String languageCode) {
        Id = id;
        this.text = text;
        this.languageCode = languageCode;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Id=" + Id +
                ", text='" + text + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
