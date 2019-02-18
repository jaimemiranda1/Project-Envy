package Game.Entities.Dynamics;

public interface Fighter {
    //copy these into the fighter
    double health=100,mana=100,xp=0l,lvl=1,defense=10,str=40,intl=30,cons=10,acc=10,evs=5,initiative=1;
    String Class = "none",skill = "none";
    String[] buffs = {},debuffs = {};
    //

    double getHealth();

    void setHealth(double health);

    double getMana();
    void setMana(double mana);
    double getXp();

    void setXp(double xp);

    double getLvl();

    void setLvl(double lvl) ;

    double getDefense();

    void setDefense(double defense);

    double getStr();

    void setStr(double str);

    double getIntl();

    void setIntl(double intl) ;

    double getCons();

    void setCons(double cons);

    double getAcc();

    void setAcc(double acc);

    double getEvs();

    void setEvs(double evs);

    double getInitiative() ;

    void setInitiative(double initiative);

    String getclass() ;

    void setClass(String aClass);
    String getSkill();

    void setSkill(String skill);

    String[] getBuffs();

    void setBuffs(String[] buffs);

    String[] getDebuffs();

    void setDebuffs(String[] debuffs);
}
