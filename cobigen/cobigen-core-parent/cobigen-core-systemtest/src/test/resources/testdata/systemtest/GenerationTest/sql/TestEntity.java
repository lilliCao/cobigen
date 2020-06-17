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

/**
 *
 */
@Entity
@Table(name = "TestEntitySetName")
public class TestEntity {
  
    @Column(name = "column_name", nullable = false)
    private Long LongVarCol;
    
    @Column(name = "column_name_nullable")
    private Long LongVar;
    
    @Column(name = "other_identity_name")
    private OtherEntity otherEntity;
    
    private List<OtherEntity> otherEntities;
    
    private VisitorEntity visitor;

    private QueueEntity queue;
   
    //entity
    /*
    private OtherEntity other;
    private QueueEntity queue;
    */
 // Primary data type   
/*    
    private Long LongVar;
    private long longVar;
    private int intVar;
    private Integer IntVar;
    
    private boolean booleanVar;
    private Boolean BooleanVar;

    private String stringVar; 
    
    private Date date;
    
    private Timestamp timestamp;
    
    private Instant instant;
    
    private Year year;
    
    private Time time;
    
    private UUID uuid;
    */
}
