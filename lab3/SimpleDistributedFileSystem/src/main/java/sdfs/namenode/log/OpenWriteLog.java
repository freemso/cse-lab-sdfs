package sdfs.namenode.log;

import java.io.Serializable;
import java.util.UUID;

public class OpenWriteLog extends Log implements Serializable {
    private String fileUri;
    private UUID token;

    public OpenWriteLog(int logID, String fileUri, UUID token) {
        super(logID, Type.OPEN_WRITE);
        this.fileUri = fileUri;
        this.token = token;
    }

    public String getFileUri() {
        return fileUri;
    }

    public UUID getToken() {
        return token;
    }
}
