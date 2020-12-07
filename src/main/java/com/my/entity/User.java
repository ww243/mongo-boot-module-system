package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/07 19:43
 */
@Document(collection = "yes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private Integer age;
    private Date birthday;
}
