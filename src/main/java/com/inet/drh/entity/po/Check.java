package com.inet.drh.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author drh
 * @since 2021-03-26
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Check implements Serializable {
    public Check(String id, String userId, String checkState, Date startTime, Date endTime, Integer account) {
        this.id = id;
        this.userId = userId;
        this.checkState = checkState;
        this.startTime = startTime;
        EndTime = endTime;
        this.account = account;
    }

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String checkState;

    private Date startTime;

    private Date EndTime;

    private Integer account;


}
