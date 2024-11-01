package com.pilzbros.PilzServerTools.plugin;

public enum Setting {
    CheckForUpdates("CheckForUpdates", true),
    NotifyOnNewUpdates("NotifyOnNewUpdates", true),
    ReportMetrics("MetricReporting", true),
    PluginProtection("Protection.PluginStealingProtection", true),
    MemoryProtection("Protection.MemoryMointoring", true),
    NotifyOnAustinPilz("NotifyOnPluginCreatorJoin", true),
    LockdownDisableMovement("DisableMovement", true),
    LockdownDisableChat("DisableChat", true),
    LockdownDisableCommands("DisableCommands", true),
    LockdownEnableMessage("EnableMessage", "Server is now in lockdown!"),
    LockdownDisableMessage("DisableMessage", "Server lockdown has ended, all functions restored!"),
    ReloadAlert("Alerts.AlertOnReload", true),
    ReloadAlertMessage("Alerts.ReloadMessage", "A server reload is in progress! Commands will be unavailable until the reload is complete"),
    SilenceModeMessage("Alerts.SilenceModeMessage", "Silence mode has been enabled. You cannot chat until it's been disabled");

    private String name;
    private Object def;

    private Setting(String Name, Object Def) {
        this.name = Name;
        this.def = Def;
    }

    public String getString() {
        return this.name;
    }

    public Object getDefault() {
        return this.def;
    }
}
