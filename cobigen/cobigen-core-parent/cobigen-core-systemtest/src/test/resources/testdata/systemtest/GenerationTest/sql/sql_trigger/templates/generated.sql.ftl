 <#if pojo.annotations.javax_persistence_Table?? && pojo.annotations.javax_persistence_Table.name??>
  <#assign tableName = pojo.annotations.javax_persistence_Table.name>
<#else>
  <#assign tableName = variables.entityName>  
</#if>
CREATE TABLE ${tableName} (        
<#assign columns = [{"name":"id", "type":"BIGINT NOT NULL AUTO_INCREMENT"}, 
                    {"name": "modificationCounter", "type": "INTEGER NOT NULL"}]>
<#assign pk = "id">                    
<#assign fkList = []> 
<#list pojo.fields as field>
  <#if field.type?contains("Entity") && !field.type?starts_with("List<") && !field.type?starts_with("Set<")>
    <#if field.annotations.javax_persistence_Column?? && field.annotations.javax_persistence_Column.name??>
      <#assign name = field.annotations.javax_persistence_Column.name>
    <#else>
      <#assign name = "id"+field.name?cap_first>  
    </#if>
    <#assign columns = columns + [{"name":name, "type":"BIGINT NOT NULL"}]>
    <#assign fkList = fkList + [{"key": name, "table": field.type}]> 
  <#else>
    <#if field.type?contains("Integer") || field.type=="int" || field.type?contains("Year") || field.type?contains("Month")>
      <#assign type = "INTEGER">
    <#elseif field.type?contains("Long") || field.type?contains("Entity") || field.type=="long">
      <#assign type = "BIGINT">
    <#elseif field.type?contains("Short") || field.type=="short">
      <#assign type = "SMALLINT">
    <#elseif field.type?contains("Float") || field.type=="float">
      <#assign type = "FLOAT">             
    <#elseif field.type?contains("Double") || field.type=="double">
      <#assign type = "DOUBLE">
    <#elseif field.type?contains("BigDecimal") || field.type?contains("BigInteger")>
      <#assign type = "NUMERIC">
    <#elseif field.type?contains("Character") || field.type=="char">
      <#assign type = "CHAR">
    <#elseif field.type?contains("Byte") || field.type=='byte'>
      <#assign type = "TINYINT">                   
    <#elseif field.type?contains("Boolean") || field.type=="boolean">
      <#assign type = "NUMBER(1) DEFAULT 0">
    <#elseif field.type?contains("Instant") || field.type?contains("Timestamp")>
      <#assign type = "TIMESTAMP">
    <#elseif field.type?contains("Date") || field.type?contains("Calender")>
      <#assign type = "DATE">
    <#elseif field.type?contains("Time")>
      <#assign type = 'TIME'>  
    <#elseif field.type?contains("UUID")>
      <#assign type = "BINARY">  
    <#elseif field.type?contains("Blob")>
      <#assign type = "BLOB">        
    <#elseif field.annotations.javax_validation_constraints_Size?? && field.annotations.javax_validation_constraints_Size.max??>
        <#assign type = "VARCHAR(" + field.annotations.javax_validation_constraints_Size.max +")">
    <#else>
        <#assign type = "VARCHAR(255)">
    </#if>     
    <#assign name = field.name> 
    <#if field.annotations.javax_persistence_Column??>
      <#if field.annotations.javax_persistence_Column.name??>
        <#assign name = field.annotations.javax_persistence_Column.name>        
      </#if>  
      <#if field.annotations.javax_persistence_Column.nullable?? && field.annotations.javax_persistence_Column.nullable=="false">
        <#assign type = type + "NOT NULL">   
      </#if>
    </#if> 
    <#assign columns = columns + [{"name":name, "type":type}]>
  </#if>
  <#if field.annotations.javax_persistence_GeneratedValue?? && field.annotations.javax_persistence_GeneratedValue.strategy=="GenerationType.IDENTITY">
    <#assign pk = name>
  </#if> 
</#list>
<#list columns as col>
  ${col.name?right_pad(30)}${col.type},
</#list>
  CONSTRAINT PK_${tableName} PRIMARY KEY(${pk}),
<#list fkList as fk>
  CONSTRAINT FK_${variables.entityName}_${fk.key} FOREIGN KEY(${fk.key}) REFERENCES ${fk.table?remove_ending("Entity")}(id),
</#list>  
);