package mvn.example.db;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DB {
    public static final DB MAIN = new DB("jdbc:mysql://localhost:3306/andrei", "root", "rIkYS6aa");
    private final String url;
    private final String user;
    private final String pass;
    @Getter @Setter
    private String nameDB = "";
    public DB(String url, String user, String pass) {
        this.url = url;
        String[] splits = url.split("/");
        nameDB = splits[splits.length - 1];
        this.user = user;
        this.pass = pass;
    }
    private Statement statement;
    private Connection connection = null;
    public Connection getConnection(boolean force) {
        if (connection != null && !force)
            return connection;
        try {
            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println(e);
        }
        return connection;
    }
    public Statement getStatement(boolean force) {
        if (statement != null && !force)
            return statement;

        try {
            statement = getConnection(false).createStatement();
        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println(e);
        }
        return statement;
    }
    public class Table {
        @Getter
        private String nameTable;
        public class Field {
            @Getter
            private String fieldName;
            @Getter
            private String type;
            @Getter
            private boolean isNull;
            @Getter
            private String key;
            @Getter
            private String def;
            @Getter
            private String extra;

            private Field(String name, String type, boolean isNull, String key, String def, String extra) {
                this.fieldName = name;
                this.type = type;
                this.isNull = isNull;
                this.key = key;
                this.def = def;
                this.extra = extra;
            }

            @Override
            public String toString() {
                return fieldName  + ":"+ type + (isNull ?"?":"!") + "("+key+","+def+","+extra+")";
            }
        }
        private Table(String name){
            this.nameTable = name;
        }

        @Override
        public String toString() {
            return "`"+nameDB+"`" + "." + "`"+nameTable+"`" ;
        }

        public List<Field> getFields(){
            List<Field> fields = new ArrayList<>();
            Statement statement = getStatement(false);
            if(statement == null) return fields;
            try {
                var st = statement.executeQuery("DESCRIBE `"+nameDB+"`" + "." + "`"+nameTable+"`");
                var meta = st.getMetaData();
                System.out.println(meta.getColumnType(1));
                while (st.next()){

                    fields.add(new Field(
                            st.getString(1),
                            st.getString(2),
                            st.getBoolean(3),
                            st.getString(4),
                            st.getString(5),
                            st.getString(6)
                    ));
                }
            } catch (SQLException e) {

            }
            return fields;

        }

    }
    public List<Table> getTables(){
        List<Table> tables = new ArrayList<>();
        Statement statement = getStatement(false);
        if(statement == null) return tables;
        try {
            var st = statement.executeQuery("SHOW TABLES;");
            while (st.next()){
                tables.add(new Table(st.getString(1)));
            }
        } catch (SQLException e) {

        }
        return tables;

    }
}
