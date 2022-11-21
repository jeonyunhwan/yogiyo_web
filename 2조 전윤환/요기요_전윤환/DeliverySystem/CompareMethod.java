package DeliverySystem;

import Database.AllSelectVo;

import java.util.Comparator;

//랭킹순 > 별점순
class CompareList implements Comparator<AllSelectVo>{

    @Override
    public int compare(AllSelectVo o1, AllSelectVo o2) {
            if (o1.getStar() < o2.getStar()) return 1;
            if (o1.getStar() > o2.getStar()) return -1;
            return 0;

    }
}
class CompareList02 implements Comparator<AllSelectVo>{

    @Override
    public int compare(AllSelectVo o1, AllSelectVo o2) {
        if(o1.getPname().compareTo(o2.getPname())<0){
            return -1;
        }
        return 1;
    }
}
class CompareList03 implements Comparator<AllSelectVo>{

    @Override
    public int compare(AllSelectVo o1, AllSelectVo o2) {
        if (o1.getDeliveryCost() < o2.getDeliveryCost()) return -1;
        if (o1.getDeliveryCost() > o2.getDeliveryCost()) return 1;
        return 0;
    }

}
class CompareList04 implements Comparator<AllSelectVo> {

    @Override
    public int compare(AllSelectVo o1, AllSelectVo o2) {
        if (o1.getMinOrderCost() < o2.getMinOrderCost()) return -1;
        if (o1.getMinOrderCost() > o2.getMinOrderCost()) return 1;
        return 0;
    }
}