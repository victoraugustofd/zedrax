package br.com.zedrax.services.vo.settings;

import java.util.List;

public class SettingsGroupVo {

    private Long idSettingsGroup;
    private String group;
    private List<SettingsAttributesVo> settingsAttributes;

    public Long getIdSettingsGroup() {
        return idSettingsGroup;
    }

    public void setIdSettingsGroup(Long idSettingsGroup) {
        this.idSettingsGroup = idSettingsGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<SettingsAttributesVo> getSettingsAttributes() {
        return settingsAttributes;
    }

    public void setSettingsAttributes(List<SettingsAttributesVo> settingsAttributes) {
        this.settingsAttributes = settingsAttributes;
    }
}