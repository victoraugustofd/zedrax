package br.com.zedrax.services.vo.settings;

public class SettingsAttributesVo {

    private Long idSettingsAttributes;
    private String attribute;
    private String defaultValue;

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
}