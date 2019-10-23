package builder.b2;

import java.util.Date;

/**
 * @author Yang zeqi
 * @date 2019/10/23
 * @description: 邮件抽象接口 （组件)
 */
public abstract class AutoMessage {

    private String to;

    private String from;

    private String subject;

    private String body;

    private Date sendDate;

    public void send(){
        System.out.println(this.toString());
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "AutoMessage{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
