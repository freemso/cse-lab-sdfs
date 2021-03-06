package sdfs.client;

import sdfs.entity.SDFSFileChannelData;
import sdfs.exception.SDFSFileAlreadyExistsException;
import sdfs.protocol.SDFSConfiguration;

import java.io.FileNotFoundException;

public class SDFSClient implements ISDFSClient {
    private NameNodeStub nameNodeStub;
    private int fileDataBlockCacheSize;


    public SDFSClient(SDFSConfiguration configuration, int fileDataBlockCacheSize) {
        this.fileDataBlockCacheSize = fileDataBlockCacheSize;
        this.nameNodeStub = new NameNodeStub(configuration.getNameNodeAddress(), configuration.getNameNodePort());
    }

    @Override
    public SDFSFileChannel openReadonly(String fileUri) throws FileNotFoundException {
        SDFSFileChannelData sdfsFileChannelData = nameNodeStub.openReadonly(fileUri);
        return new SDFSFileChannel(sdfsFileChannelData, nameNodeStub, fileDataBlockCacheSize);
    }

    @Override
    public SDFSFileChannel openReadWrite(String fileUri) throws FileNotFoundException {
        SDFSFileChannelData sdfsFileChannelData = nameNodeStub.openReadwrite(fileUri);
        return new SDFSFileChannel(sdfsFileChannelData, nameNodeStub, fileDataBlockCacheSize);
    }

    @Override
    public SDFSFileChannel create(String fileUri) throws SDFSFileAlreadyExistsException, FileNotFoundException {
        SDFSFileChannelData sdfsFileChannelData = nameNodeStub.create(fileUri);
        return new SDFSFileChannel(sdfsFileChannelData, nameNodeStub, fileDataBlockCacheSize);
    }

    @Override
    public void mkdir(String fileUri) throws SDFSFileAlreadyExistsException, FileNotFoundException {
        nameNodeStub.mkdir(fileUri);
    }
}
