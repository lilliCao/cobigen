package main;

import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 */
public class TestEntity {
  
    @Column(name = "column_name", nullable = false)
    private Long LongVarCol;
    
    @Column(name = "column_name_nullable")
    private Long LongVar;
    
    private OtherEntity otherEntity;
    private List<OtherEntity> otherEntities;
   
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
