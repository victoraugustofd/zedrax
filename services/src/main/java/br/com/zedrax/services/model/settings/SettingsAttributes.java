package br.com.zedrax.services.model.settings;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the "settings_attributes" database table.
 * 
 */
@Entity
@Table(name = "settings_attributes", uniqueConstraints = @UniqueConstraint(name = "uk_settings_attributes__attribute", columnNames = "attribute"))
public class SettingsAttributes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_settings_attributes", nullable = false, insertable = false, updatable = false)
    private Long idSettingsAttributes;

    @Column(name = "attribute", nullable = false)
    @Length(max = 45)
    private String attribute;

    @Column(name = "default_value", nullable = false)
    @Length(max = 45)
    private String defaultValue;

    @ManyToOne(targetEntity = SettingsGroup.class)
    @JoinColumn(name = "id_settings_group", nullable = false, foreignKey = @ForeignKey(name = "fk_settings_attribute__settings_group"))
    private SettingsGroup settingsGroup;

    public SettingsAttributes() {
    }

    public SettingsAttributes(String attribute, String defaultValue, SettingsGroup settingsGroup) {

        setAttribute(attribute);
        setDefaultValue(defaultValue);
        setSettingsGroup(settingsGroup);
    }

    public Long getIdSettingsAttributes() {
        return idSettingsAttributes;
    }

    public void setIdSettingsAttributes(Long idSettingsAttributes) {
        this.idSettingsAttributes = idSettingsAttributes;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public SettingsGroup getSettingsGroup() {
        return settingsGroup;
    }

    public void setSettingsGroup(SettingsGroup settingsGroup) {
        this.settingsGroup = settingsGroup;
    }

    @Override
    public boolean equals(Object obj) {
        
        boolean equals = false;

        if (obj != this) {
            
            if (obj instanceof SettingsAttributes) {
                
                SettingsAttributes settingsAttributes = (SettingsAttributes) obj;

                if (Objects.equals(attribute, settingsAttributes.getAttribute())) {
                    equals = true;
                }
            }
        }

        return equals;
    }
}