package ro.sorin.pocs.java.springframework.usermanagement.service;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity {

  @Setter
  protected Long id;

  @Setter
  @Getter
  @CreationTimestamp
  @Column(name = "created", nullable = false)
  private LocalDateTime created;

  @Setter
  @Getter
  @UpdateTimestamp
  @Column(name = "updated", nullable = false)
  private LocalDateTime updated;

  @Version
  private Integer version;

//  protected Long getBaseId() {
//    return this.id;
//  }
}
