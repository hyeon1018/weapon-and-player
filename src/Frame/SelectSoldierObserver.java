package Frame;

import Map.*;

public class SelectSoldierObserver implements Observer{

    private SelectSoldierFrame[] subject = new SelectSoldierFrame[2];
    private Map map;
    public SelectSoldierObserver(Map map){
        this.map = map;

        map.getP1().getHero().initSpeciality(map.getP1());
        map.getP2().getHero().initSpeciality(map.getP2());

        subject[0] = new SelectSoldierFrame(map, map.getP1());
        subject[1] = new SelectSoldierFrame(map, map.getP2());
        subject[0].setObserver(this);
        subject[1].setObserver(this);
        subject[1].setLocation(1000, 100);
    }

    @Override
    public void updateViewers() {
        // TODO connect to next Frame (PlayFrame)
        boolean allSelected = true;
        for(int i = 0 ; i < subject.length ; i++){
            allSelected = allSelected & subject[i].isSelected();
        }

        if(allSelected){
            subject[0].dispose();
            subject[0].dispose();
            new PlayObserver(map);
        }
    }
}
