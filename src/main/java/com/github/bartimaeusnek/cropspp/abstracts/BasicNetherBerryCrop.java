package com.github.bartimaeusnek.cropspp.abstracts;

import com.github.bartimaeusnek.cropspp.ConfigValures;

import ic2.api.crops.ICropTile;

public abstract class BasicNetherBerryCrop extends BasicBerryCrop {


	public BasicNetherBerryCrop ()
	{
		super();
	}

    
    @Override
    public int tier() {
        return 4;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 1;   // a bit chemical
        case 1: return 3;   // kinda edible
        case 2: return 4;   // strong defensive properties
        case 3: return 4;   // quite colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    @Override
	public boolean canGrow(ICropTile crop) {
	    	if (crop.getSize() < 1) 
	            return true;
	    	else 
	            return crop.getSize() < 3;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires no humidity but nutrients.
        return (int)((double)humidity*0.5 + (double)nutrients*1.5 + (double)air*1);
    }

    @Override
    public int growthDuration(ICropTile crop) {
    	int r;
        // Same growth stages as melons and pumpkins
    	if (ConfigValures.Debug == true)
    		r = 1;
    	else if (crop.getSize() == 2) {
            // Ripens not so quickly
        	r = 300;
        } else {
            // Takes a while to grow from seed
        	r = 700;
        }
    	return r;
    }

}
