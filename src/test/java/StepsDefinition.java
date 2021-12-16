import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StepsDefinition {
    private static final String ACCESS_TOKEN = "WCn7fGTmUUsAAAAAAAAAAa0S0z5YMQ42iS4UlC3jrGURzCb7m2IVHdp1kv4_DDE8";
    private static DbxClientV2 client;
    private static InputStream in;
    private static Metadata metadata;

    @BeforeAll
    public static void beforeAll(){
        DbxRequestConfig config = DbxRequestConfig.newBuilder("https://api.dropbox.com/my_app_for_lab").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);

    }
    @Given("User have file to upload with path {string}")
    public void user_have_file_to_upload_with_path(String path) {
        try {
            in = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    @When("User uploads file with name {string}")
    public void user_uploads_file_with_name(String name) throws IOException, DbxException {
        client.files().uploadBuilder("/"+name).uploadAndFinish(in);
    }
    @Then("User can get info on file with name {string}")
    public void user_can_get_info_on_file_with_name(String name) throws DbxException {
        client.files().getMetadata("/"+name);
    }


    @Given("File {string} is uploaded")
    public void file_is_uploaded(String name) throws DbxException {
        client.files().getMetadata("/"+name);
    }
    @When("User gets file metadata with name {string}")
    public void user_gets_file_metadata_with_name(String name) throws DbxException {
        metadata = client.files().getMetadata("/"+name);
    }
    @Then("User sees file metadata")
    public void user_sees_file_metadata() {
        System.out.println("File`s metadata:");
        System.out.println(metadata.toStringMultiline());
    }

    @When("User deletes file with name {string}")
    public void user_deletes_file_with_name(String name) throws DbxException {
        client.files().deleteV2("/"+name);
    }
    @Then("File is deleted")
    public void file_is_deleted() throws DbxException {
        ListFolderResult result=client.files().listFolder("");
        System.out.println("List of files:");
        for (Metadata folder : result.getEntries()) {
            System.out.println(folder.getName());
        }
    }


}
