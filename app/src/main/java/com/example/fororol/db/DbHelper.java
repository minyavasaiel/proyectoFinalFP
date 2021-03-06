package com.example.fororol.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="personajeshp";
    public static final String TABLE_VIGOR = "tVigor";
    public static final String TABLE_DEX = "tDex";
    public static final String TABLE_CARISMA = "tCarisma";
    public static final String TABLE_PODER = "tPoder";
    public static final String TABLE_VOLUNTAD = "tVoluntad";
    public static final String TABLE_PERCEPCION = "tPercepcion";
    public static final String TABLE_INTELIGENCIA = "tInteligencia";
    public static final String TABLE_PJ = "tPJ";
    public static final String TABLE_VIGORD = "tVigorD";
    public static final String TABLE_DEXD = "tDexD";
    public static final String TABLE_CARISMAD = "tCarismaD";
    public static final String TABLE_PODERD = "tPoderD";
    public static final String TABLE_VOLUNTADD = "tVoluntadD";
    public static final String TABLE_PERCEPCIOND = "tPercepcionD";
    public static final String TABLE_INTELIGENCIAD = "tInteligenciaD";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_VIGOR+"(idv INTEGER PRIMARY KEY AUTOINCREMENT, vigor INTEGER, atletismo INTEGER, pelea INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_DEX+"(idd INTEGER PRIMARY KEY AUTOINCREMENT, destreza INTEGER, esquivar INTEGER, latrocinio INTEGER, sigilo INTEGER, volar INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_CARISMA+"(idc INTEGER PRIMARY KEY AUTOINCREMENT, carisma INTEGER, coordinacion INTEGER, intimidacion INTEGER, oratoria INTEGER, seducir INTEGER, subterfugio INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_PODER+"(idp INTEGER PRIMARY KEY AUTOINCREMENT, poder INTEGER, duelo INTEGER, pociones INTEGER, rituales INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_VOLUNTAD+"(idvo INTEGER PRIMARY KEY AUTOINCREMENT, voluntad INTEGER, arte INTEGER, estilo INTEGER, frialdad INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_PERCEPCION+"(idpe INTEGER PRIMARY KEY AUTOINCREMENT, percepcion INTEGER, alerta INTEGER, consciencia INTEGER, empatia INTEGER, iniciativa INTEGER, investigacion INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_INTELIGENCIA+"(idi INTEGER PRIMARY KEY AUTOINCREMENT, inteligencia INTEGER, adivinacion INTEGER, arcanismo INTEGER, callejeo INTEGER, culturaMagia INTEGER, culturaMuggle INTEGER, herbologia INTEGER, magizoologia INTEGER, medicina INTEGER, politica INTEGER, supervivencia INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_PJ+"(idpj INTEGER PRIMARY KEY AUTOINCREMENT, nombre String, etapa String)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_VIGORD+"(idvd INTEGER PRIMARY KEY AUTOINCREMENT, vigor INTEGER, atletismo INTEGER, pelea INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_DEXD+"(iddd INTEGER PRIMARY KEY AUTOINCREMENT, destreza INTEGER, esquivar INTEGER, latrocinio INTEGER, sigilo INTEGER, volar INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_CARISMAD+"(idcd INTEGER PRIMARY KEY AUTOINCREMENT, carisma INTEGER, coordinacion INTEGER, intimidacion INTEGER, oratoria INTEGER, seducir INTEGER, subterfugio INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_PODERD+"(idpd INTEGER PRIMARY KEY AUTOINCREMENT, poder INTEGER, duelo INTEGER, pociones INTEGER, rituales INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_VOLUNTADD+"(idvod INTEGER PRIMARY KEY AUTOINCREMENT, voluntad INTEGER, arte INTEGER, estilo INTEGER, frialdad INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_PERCEPCIOND+"(idped INTEGER PRIMARY KEY AUTOINCREMENT, percepcion INTEGER, alerta INTEGER, consciencia INTEGER, empatia INTEGER, iniciativa INTEGER, investigacion INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_INTELIGENCIAD+"(idid INTEGER PRIMARY KEY AUTOINCREMENT, inteligencia INTEGER, adivinacion INTEGER, arcanismo INTEGER, callejeo INTEGER, culturaMagia INTEGER, culturaMuggle INTEGER, herbologia INTEGER, magizoologia INTEGER, medicina INTEGER, politica INTEGER, supervivencia INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_VIGOR);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_DEX);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_CARISMA);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_PODER);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_VOLUNTAD);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_PERCEPCION);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_INTELIGENCIA);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_PJ);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_VIGORD);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_DEXD);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_CARISMAD);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_PODERD);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_VOLUNTADD);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_PERCEPCIOND);
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_INTELIGENCIAD);

        onCreate(sqLiteDatabase);
    }
}
