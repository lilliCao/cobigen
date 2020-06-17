package main;

import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.devonfw.application.jtqj.accesscodemanagement.common.api.AccessCode;
import com.devonfw.application.jtqj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;
import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.VisitorEntity;

@Entity
@Table(name = "AccessCode")
public class AccessCodeEntity extends ApplicationPersistenceEntity implements AccessCode {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessCodeId;
    
    @Size(min = 2, max = 5)
    private String ticketNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endTime;

    private VisitorEntity visitor;

    private QueueEntity queue;
    
}