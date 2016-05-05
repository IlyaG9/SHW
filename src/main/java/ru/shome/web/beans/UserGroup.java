package ru.shome.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
/**
 * @author ILYA
 *
 */
@Entity
@Table(name = "user_group")
public class UserGroup {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "group_id")
	private Long id;
	
	@Column(name = "group_identifier",unique = true,nullable=false)
	private String groupIdentifier;
	
	@Column(name = "group_description",unique = true,nullable=false)
	private String groupDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupIdentifier() {
		return groupIdentifier;
	}

	public void setGroupIdentifier(String groupIdentifier) {
		this.groupIdentifier = groupIdentifier;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	
	
}
