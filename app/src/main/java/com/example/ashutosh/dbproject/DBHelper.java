package com.example.ashutosh.dbproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.*;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "college.application";

    public Context context;

    public String CREATE_TABLE_USER = "CREATE TABLE User(User_ID TEXT PRIMARY KEY ,UType TEXT )";
    public String CREATE_TABLE_STUDENT = "CREATE TABLE Student(Fname TEXT ,Minit TEXT ,Lname TEXT ,Roll_No TEXT ,Sex TEXT ,DOB TEXT ,Dno INTEGER ,User_No TEXT ,PRIMARY KEY (Roll_No,User_No) ,FOREIGN KEY (User_No) REFERENCES User(User_ID) )";
    public String CREATE_TABLE_EVENT = "CREATE TABLE Event(Team_Size INTEGER ,Event_Name TEXT ,Date TEXT ,Event_ID TEXT PRIMARY KEY ,Venue TEXT ,Organizer TEXT ,Level TEXT ,Award_Type TEXT )";
    public String CREATE_TABLE_PLAYS_SPORT = "CREATE TABLE Plays_Sport(SRoll TEXT ,S_ID TEXT ,Sname TEXT,PRIMARY KEY (SRoll,S_ID) ,FOREIGN KEY (SRoll) REFERENCES Student(Roll_No) ,FOREIGN KEY (S_ID) REFERENCES Event(Event_ID) )";
    public String CREATE_TABLE_DEPARTMENT = "CREATE TABLE Department(Dnumber INTEGER PRIMARY KEY ,Dname TEXT )";
    public String CREATE_TABLE_CULTURAL = "CREATE TABLE Cultural(CRoll TEXT ,C_ID TEXT ,CType TEXT ,PRIMARY KEY (CRoll,C_ID) ,FOREIGN KEY (CRoll) REFERENCES Student(Roll_No) ,FOREIGN KEY (C_ID) REFERENCES Event(Event_ID) )";
    public String CREATE_TABLE_ACADEMICS = "CREATE TABLE Academics(ARoll TEXT ,Dname TEXT ,A_ID TEXT ,PRIMARY KEY (A_ID,ARoll) ,FOREIGN KEY (A_ID) REFERENCES Event(Event_ID) ,FOREIGN KEY (ARoll) REFERENCES Student(Roll_No))";

    //Constructor.
    public DBHelper(Context context )
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_EVENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_PLAYS_SPORT);
        sqLiteDatabase.execSQL(CREATE_TABLE_DEPARTMENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_CULTURAL);
        sqLiteDatabase.execSQL(CREATE_TABLE_ACADEMICS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Student");
        db.execSQL("DROP TABLE IF EXISTS Event");
        db.execSQL("DROP TABLE IF EXISTS Plays_Sport");
        db.execSQL("DROP TABLE IF EXISTS Department");
        db.execSQL("DROP TABLE IF EXISTS Cultural");
        db.execSQL("DROP TABLE IF EXISTS Academics");

        // create new tables
        onCreate(db);
    }

    public void insertUsers()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String InsertQuery = "INSERT INTO User VALUES('AD001','Admin'),('AD002','Admin'),('AD003','Admin'),('AD004','Admin'),('AD005','Admin'),('ST001','Student'),('ST002','Student'),('ST003','Student'),('ST004','Student'),('ST005','Student'),('ST006','Student'),('ST007','Student'),('ST008','Student')";

        database.execSQL(InsertQuery);
    }

    public void insertStudents()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "INSERT INTO Student VALUES('Akhil','S','Jasrotia','CED16I003','M','1999-01-17',1,'ST005'),('Ankita','','Chandra','CED16I004','F','1998-03-20',1,'ST001'),('Meghana','','Kanikarla','CED16I014','F','1998-11-08',1,'ST004'),('Nipun','','Bharti','CED16I026','M','1998-03-14',1,'ST003'),('Saurav','C','Purva','CED16I029','M','1997-09-24',1,'AD002'),('Vaishnavi','','Sriram','COE16B036','F','1998-07-12',1,'ST006'),('Prachi','','Mittal','ESD17I009','F','1998-01-13',3,'ST007'),('Smita','','','EVD17I016','F','1998-12-18',3,'AD003'),('Manali','G','Thonte','MPD16I014','F','1997-09-28',2,'ST002'),('Sriya','K','Chakravorty','MSM16B015','F','1998-06-04',2,'AD001')";
        db.execSQL(insertQuery);
    }

    public void insertEvents()
    {
        SQLiteDatabase db  = this.getWritableDatabase();
        String insertEvents = "INSERT INTO Event VALUES(1,'Codewell','2017-08-14','ACD001','Chennai','CodeBlock','National','Certificate'),(3,'Codewell','2017-08-15','ACD002','Chennai','CodeBlock','National','Certificate'),(4,'Mechnovate','2018-12-12','ACD003','Chennai','IIIT','College','Certificate'),(3,'Electrohunt','2018-01-12','ACD004','Chennai','IIIT','College','Certificate'),(3,'Robo Wars','2017-01-12','ACD005','Chennai','IIIT','College','Certificate'),(3,'Robo Wars','2016-01-12','ACD006','Varnasi','IIT','College','Certificate'),(1,'Hackathon','2016-01-01','ACD007','Bombay','IBM','National','Prize Money'),(1,'Hackathon','2017-01-01','ACD008','Bombay','IBM','National','Prize Money'),(1,'Hackathon','2016-01-01','ACD009','Bombay','IBM','National','Prize Money'),(3,'Pitch Please','2017-11-22','ACD010','Chennai','IIIT','College','Certificate'),(1,'Impulse','2017-06-05','CUL001','Chennai','IIITDM','College','Prize Money'),(1,'Instyle','2017-10-15','CUL002','Chennai','IIITDM','College','Prize Money'),(2,'Duet','2017-07-03','CUL003','Hyderabad','IIIT','College','Certificate'),(5,'Sync-Geet','2017-07-24','CUL004','Hyderabad','IIIT','College','Certificate'),(2,'Face Painting','2017-10-11','CUL005','Chennai','NIT','College','Certificate'),(1,'Nail art','2017-10-11','CUL006','Chennai','NIT','College','Certificate'),(1,'Tattoo','2017-10-12','CUL007','Chennai','NIT','College','Certificate'),(1,'Speak','2017-11-11','CUL008','Bombay','IITB','College','Certificate'),(2,'Table Tennis','2016-07-24','SPT001','Hyderabad','IIIT','College','Medals'),(7,'Basket Ball','2015-08-24','SPT002','Gwalior','IIIT Gwalior','College','Certificate'),(2,'Table Tennis','2015-07-24','SPT003','Hyderabad','IIIT','College','Medals'),(3,'Badminton','2017-07-24','SPT004','Chennai','IIT','College','Medals'),(3,'Table Tennis','2016-01-22','SPT005','Gwalior','IIIT Gwalior','National','Medals'),(3,'Squash','2016-01-29','SPT006','Gwalior','IIIT Gwalior','College','Medals'),(1,'Swimming','2016-01-19','SPT007','Gwalior','IIIT Gwalior','College','Medals'),(1,'Tennis','2017-05-17','SPT008','Hyderabad','IITH','College','Medals'),(3,'Tennis','2017-05-16','SPT009','Hyderabad','IITH','College','Medals')";
        db.execSQL(insertEvents);
    }

    public void insertPlaySports()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertPlaySports = "INSERT INTO Plays_Sport VALUES('COE16B036','SPT001','Table Tennis'),('COE16B036','SPT003','Table Tennis'),('COE16B036','SPT005','Table Tennis'),('COE16B036','SPT002','Table Tennis'),('CED16I004','SPT002','Basket Ball'),('CED16I004','SPT007','Swimming'),('CED16I026','SPT004','Badminton'),('CED16I003','SPT008','Lawn Tennis'),('EVD17I016','SPT009','Lawn Tennis'),('EVD17I016','SPT004','Badminton'),('EVD17I016','SPT006','Squash'),('ESD17I009','SPT006','Squash'),('MSM16B015','SPT006','Squash')";
        db.execSQL(insertPlaySports);
    }

    public void insertDepartments()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertDepartment = "INSERT INTO Department VALUES (1,'Computer'),(2,'Mechanical'),(3,'Electronics')";
        db.execSQL(insertDepartment);
    }

    public void insertCulturals()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertCultural = "INSERT INTO Cultural VALUES('MSM16B015','CUL008','Elocution'),('MPD16I014','CUL008','Elocution'),('CED16I014','CUL007','Drawing'),('CED16I004','CUL007','Drawing'),('CED16I003','CUL004','Singing'),('CED16I026','CUL004','Singing'),('CED16I026','CUL003','Singing'),('CED16I029','CUL002','Dnacing'),('CED16I004','CUL002','Dancing'),('CED16I029','CUL001','Dancing'),('ESD17I009','CUL001','Dancing'),('CED16I014','CUL005','Drawing'),('CED16I004','CUL005','Drawing'),('CED16I026','CUL006','Drawing'),('MPD16I014','CUL006','Drawing')";
        db.execSQL(insertCultural);
    }

    public void insertAcademics()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertAcad = "INSERT INTO Academics VALUES('CED16I004','Computers','ACD007'),('CED16I004','Computers','ACD008'),('CED16I014','Computers','ACD009'),('CED16I029','Mechanical','ACD003'),('MSM16B015','Mechanical','ACD003'),('MPD16I014','Mechanical','ACD005'),('MPD16I014','Mechanical','ACD006'),('EVD17I016','Electronics','ACD004'),('COE16B036','Computers','ACD008'),('CED16I029','Computers','ACD008'),('CED16I026','Computers','ACD001'),('CED16I026','Computers','ACD002'),('CED16I003','Mechanical','ACD003'),('CED16I026','Mechanical','ACD007')";
        db.execSQL(insertAcad);
    }

    public List<String> selectFirstQuery()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select distinct Fname from Student,Event,Plays_Sport where SRoll=Roll_No and S_ID=Event_ID and Award_Type='Medals'";

        List<String> fNameList = new ArrayList<String>();

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do{

                fNameList.add(cursor.getString(cursor.getColumnIndex("Fname")));
                //Toast.makeText(context, ""+cursor.getString(cursor.getColumnIndex("Fname")), Toast.LENGTH_SHORT).show();

            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return fNameList;
    }

    public List<Event> selectSecondQuery()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from Event";

        List<Event> eventList = new ArrayList<Event>();

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do {
                Event e = new Event();
                e.setTeam_Size(cursor.getInt(cursor.getColumnIndex("Team_Size")));
                e.setEvent_Name(cursor.getString(cursor.getColumnIndex("Event_Name")));
                e.setDate(cursor.getString(cursor.getColumnIndex("Date")));
                e.setEvent_ID(cursor.getString(cursor.getColumnIndex("Event_ID")));
                e.setVenue(cursor.getString(cursor.getColumnIndex("Venue")));
                e.setOrganizer(cursor.getString(cursor.getColumnIndex("Organizer")));
                e.setLevel(cursor.getString(cursor.getColumnIndex("Level")));
                e.setAward_Type(cursor.getString(cursor.getColumnIndex("Award_Type")));

                int sM = Integer.parseInt(e.getDate().substring(5,7));
                int eM = Integer.parseInt(e.getDate().substring(8,e.getDate().length()));
                if(sM>=7 && eM<=11) {
                    //Toast.makeText(context, "" + cursor.getString(cursor.getColumnIndex("Date")), Toast.LENGTH_SHORT).show();
                    eventList.add(e);
                }

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return eventList;
    }

    public List<String> selectThirdQuery()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select distinct Organizer from Event where Event_ID like'%CUL%' and Organizer not in (select Organizer from Event where Event_ID like'%ACD%') and Organizer not in(select Organizer from Event where Event_ID like'%SPT%')";

        List<String> organizersList = new ArrayList<String>();

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do {
                organizersList.add(cursor.getString(cursor.getColumnIndex("Organizer")));
                //Toast.makeText(context, ""+cursor.getString(cursor.getColumnIndex("Organizer")), Toast.LENGTH_SHORT).show();
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return organizersList;
    }

    public List<FourthResult> selectFourthQuery()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select distinct Roll_No,Fname,Minit,Lname from student,Plays_Sport,Event where Roll_No=SRoll and Event_ID=S_ID and Roll_No in(select ARoll from Academics,Event where A_ID=Event_ID) and Roll_No in(select CRoll from Cultural,Event where C_ID=Event_ID)";

        List<FourthResult> results = new ArrayList<FourthResult>();

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {

                FourthResult f = new FourthResult();
                f.setRoll_No(cursor.getString(cursor.getColumnIndex("Roll_No")));
                f.setFname(cursor.getString(cursor.getColumnIndex("Fname")));
                f.setMinit(cursor.getString(cursor.getColumnIndex("Minit")));
                f.setLname(cursor.getString(cursor.getColumnIndex("Lname")));

                //Toast.makeText(context, ""+f.getRoll_No()+" "+f.getFname()+" "+f.getMinit()+" "+f.getLname(), Toast.LENGTH_SHORT).show();
                results.add(f);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;
    }
}
