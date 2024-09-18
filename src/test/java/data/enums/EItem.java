package data.enums;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public enum EItem {
    Elements("Elements", null, "elements"),
    TextBox("Text Box", Elements, "text-box"),
    CheckBox("Check Box", Elements, "checkbox"),
    RadioButton("Radio Button", Elements, "radio-button"),
    WebTables("Web Tables", Elements, "webtables"),
    Buttons("Buttons", Elements, "buttons"),
    Links("Links", Elements, "links"),
    BrokenLinks("Broken Links - Images", Elements, "broken"),
    UploadDownload("Upload and Download", Elements, "upload-download"),
    Dynamic("Dynamic Properties", Elements, "dynamic-properties"),
    Forms("Forms", null, "forms"),
    PracticeForm("Practice Form", Forms, "automation-practice-form"),
    AlertsFrameWindow("Alerts, Frame & Windows", null, "alertsWindows"),
    Browser("Browser Windows", AlertsFrameWindow, "browser-windows"),
    Alerts("Alerts", AlertsFrameWindow, "alerts"),
    Frames("Frames", AlertsFrameWindow, "frames"),
    Nested("Nested Frames", AlertsFrameWindow, "nestedframes"),
    Modal("Modal Dialogs", AlertsFrameWindow, "modal-dialogs"),
    Widgets("Widgets", null, "widgets"),
    Accordian("Accordian", Widgets, "accordian"),
    Auto("Auto Complete", Widgets, "auto-complete"),
    Date("Date Picker", Widgets, "date-picker"),
    Slider("Slider", Widgets, "slider"),
    Progress("Progress Bar", Widgets, "progress-bar"),
    Tabs("Tabs", Widgets, "tabs"),
    Tool("Tool Tips", Widgets, "tool-tips"),
    Menu("Menu", Widgets, "menu"),
    Select("Select Menu", Widgets, "select-menu"),
    Interactions("Interactions", null, "interaction"),
    Sortable("Sortable", Interactions, "sortable"),
    Selectable("Selectable", Interactions, "selectable"),
    Resizable("Resizable", Interactions, "resizable"),
    Droppable("Droppable", Interactions, "droppable"),
    Dragabble("Dragabble", Interactions, "dragabble"),
    BookStoreApplication("Book Store Application", null, "books"),
    Login("Login", BookStoreApplication, "login"),
    BookStore("Book Store", BookStoreApplication, "books"),
    Profile("Profile", BookStoreApplication, "profile"),
    BookStoreAPI("Book Store API", BookStoreApplication, "swagger");

    public static final EItem @NotNull [] getByParent(EItem item) {
        return Arrays.stream(ALL).filter(it -> it.parent == item).toArray(EItem[]::new);
    }

    public static final EItem[] MAIN = {
            Elements,
            Forms,
            AlertsFrameWindow,
            Widgets,
            Interactions,
            BookStoreApplication
    };

    public static final EItem[] ELEMENTS = {
            TextBox,
            CheckBox,
            RadioButton,
            WebTables,
            Buttons,
            Links,
            BrokenLinks,
            UploadDownload,
            Dynamic
    };

    public static final EItem[] FORMS = {
            PracticeForm
    };

    public static final EItem[] ALERTS = {
            Browser,
            Alerts,
            Frames,
            Nested,
            Modal
    };

    public static final EItem[] WIDGETS = {
            Accordian,
            Auto,
            Date,
            Slider,
            Progress,
            Tabs,
            Tool,
            Menu,
            Select
    };

    public static final EItem[] INTERACTIONS = {
            Sortable,
            Selectable,
            Resizable,
            Droppable,
            Dragabble
    };

    public static final EItem[] BOOK = {
            Login,
            BookStore,
            Profile,
            BookStoreAPI
    };

    public static final EItem[] ALL = {
            Elements,
            TextBox,
            CheckBox,
            RadioButton,
            WebTables,
            Buttons,
            Links,
            BrokenLinks,
            UploadDownload,
            Dynamic,
            Forms,
            PracticeForm,
            AlertsFrameWindow,
            Browser,
            Alerts,
            Frames,
            Nested,
            Modal,
            Widgets,
            Accordian,
            Auto,
            Date,
            Slider,
            Progress,
            Tabs,
            Tool,
            Menu,
            Select,
            Interactions,
            Sortable,
            Selectable,
            Resizable,
            Droppable,
            Dragabble,
            BookStoreApplication,
            Login,
            BookStore,
            Profile,
            BookStoreAPI,
    };

    EItem(String text, @Nullable EItem parent) {
        this(text, parent, "TODO");
    }

    EItem(String text, @Nullable EItem parent, String path) {
        this.text = text;
        this.parent = parent;
        this.path = path;
    }

    private final String text;
    private final EItem parent;
    private final String path;

    public String getText() {
        return text;
    }

    public EItem getParent() {
        return parent;
    }

    public String getPath() {
        return path;
    }

    @Contract(pure = true)
    public @NotNull String xPathCard() {
        return "//h5[text()='" + text + "']";
    }

    @Contract(pure = true)
    public @NotNull String xPathMenu() {
        return "//span[text()='" + text + "']";
    }
}
