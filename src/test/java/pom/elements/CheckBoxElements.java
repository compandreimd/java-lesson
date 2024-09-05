package pom.elements;

public enum CheckBoxElements {
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
    public static final CheckBoxElements[] ALL = new CheckBoxElements[]{
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
    public static final CheckBoxElements[] DESKTOP = new CheckBoxElements[]{
            Desktop,
            Notes,
            Commands,
    };
    public static final CheckBoxElements[] DOCUMENTS = new CheckBoxElements[]{
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
    public static final CheckBoxElements[] WORKSPACE = new CheckBoxElements[]{
            Workspace,
            React,
            Angular,
            Veu
    };
    public static final CheckBoxElements[] OFFICE = new CheckBoxElements[]{
            Office,
            Public,
            Private,
            Classified,
            General
    };
    public static final CheckBoxElements[] DOWNLOAD = new CheckBoxElements[]{
            Downloads,
            WordFile,
            ExcelFile
    };
}
