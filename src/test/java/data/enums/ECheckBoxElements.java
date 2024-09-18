package data.enums;

public enum ECheckBoxElements {
    Home,
    Desktop,
    Notes,
    Commands,
    Documents,
    Workspace,
    React,
    Angular,
    Veu,
    Office,
    Public,
    Private,
    Classified,
    General,
    Downloads,
    WordFile,
    ExcelFile;
    @Override
    public String toString() {
        return switch (this)
                {
                    case Home -> "home";
                    case Desktop -> "desktop";
                    case Notes -> "notes";
                    case Commands -> "commands";
                    case Documents -> "documents";
                    case Workspace -> "workspace";
                    case React -> "react";
                    case Angular -> "angular";
                    case Veu -> "veu";
                    case Office -> "office";
                    case Public -> "public";
                    case Private -> "private";
                    case Classified -> "classified";
                    case General -> "general";
                    case Downloads -> "downloads";
                    case WordFile -> "wordFile";
                    case ExcelFile -> "excelFile";
                };
    }
    public static final ECheckBoxElements[] ALL = new ECheckBoxElements[]{
            Home,
            Desktop,
            Notes,
            Commands,
            Documents,
            Workspace,
            React,
            Angular,
            Veu,
            Office,
            Public,
            Private,
            Classified,
            General,
            Downloads,
            WordFile,
            ExcelFile
    };
    public static final ECheckBoxElements[] DESKTOP = new ECheckBoxElements[]{
            Desktop,
            Notes,
            Commands,
    };
    public static final ECheckBoxElements[] DOCUMENTS = new ECheckBoxElements[]{
            Documents,
            Workspace,
            React,
            Angular,
            Veu,
            Office,
            Public,
            Private,
            Classified,
            General
    };
    public static final ECheckBoxElements[] WORKSPACE = new ECheckBoxElements[]{
            Workspace,
            React,
            Angular,
            Veu
    };
    public static final ECheckBoxElements[] OFFICE = new ECheckBoxElements[]{
            Office,
            Public,
            Private,
            Classified,
            General
    };
    public static final ECheckBoxElements[] DOWNLOAD = new ECheckBoxElements[]{
            Downloads,
            WordFile,
            ExcelFile
    };
}