package sdfs.filetree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlockInfo implements Serializable, Iterable<LocatedBlock> {
    private static final long serialVersionUID = 8712105981933359634L;
    private final List<LocatedBlock> locatedBlockList = new ArrayList<>();

    @Override
    public Iterator<LocatedBlock> iterator() {
        return locatedBlockList.iterator();
    }

    public boolean addLocatedBlock(LocatedBlock locatedBlock) {
        return locatedBlockList.add(locatedBlock);
    }

    public boolean removeLocatedBlock(LocatedBlock locatedBlock) {
        return locatedBlockList.remove(locatedBlock);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockInfo that = (BlockInfo) o;

        return locatedBlockList.equals(that.locatedBlockList);
    }

    @Override
    public int hashCode() {
        return locatedBlockList.hashCode();
    }

    public BlockInfo deepCopy() {
        BlockInfo blockInfo = new BlockInfo();
        for (LocatedBlock locatedBlock :
                locatedBlockList) {
            blockInfo.addLocatedBlock(locatedBlock.deepCopy());
        }
        return blockInfo;
    }
}
