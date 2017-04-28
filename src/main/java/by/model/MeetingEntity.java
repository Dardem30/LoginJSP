package by.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by УВД on 25.04.2017.
 */
@Entity
@Table(name = "meeting", schema = "tutorial", catalog = "")
public class MeetingEntity {
    private long meetingId;
    private String subject;
    private Date meetingDate;

    @Id
    @Column(name = "meeting_id")
    public long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(long meetingId) {
        this.meetingId = meetingId;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "meeting_date")
    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingEntity that = (MeetingEntity) o;

        if (meetingId != that.meetingId) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (meetingDate != null ? !meetingDate.equals(that.meetingDate) : that.meetingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (meetingId ^ (meetingId >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (meetingDate != null ? meetingDate.hashCode() : 0);
        return result;
    }
}
