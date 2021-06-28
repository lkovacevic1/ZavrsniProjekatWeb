package rs.raf.ZavrsniProjekat.repositories.subject;

import org.apache.commons.codec.digest.DigestUtils;
import rs.raf.ZavrsniProjekat.entities.Category;
import rs.raf.ZavrsniProjekat.entities.News;
import rs.raf.ZavrsniProjekat.entities.User;
import rs.raf.ZavrsniProjekat.entities.UserTipe;
import rs.raf.ZavrsniProjekat.repositories.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlRepository extends MySqlAbstractRepository implements NewsRepositorty {

    @Override
    public List<UserTipe> allUserTipes() {
        List<UserTipe> userTipes = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tipkorisnika");
            while(resultSet.next()){
                userTipes.add(new UserTipe(resultSet.getInt("IdTipKorisnika"), resultSet.getString("naziv")));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            this.closeStatment(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return userTipes;
    }

    @Override
    public User findUser(User findUser) {
        User user = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String shaPassword = DigestUtils.sha256Hex(findUser.getLozinka());
            preparedStatement = connection.prepareStatement("SELECT * FROM korisnik WHERE Email = ? and Lozinka = ? and Status = true");
            preparedStatement.setString(1, findUser.getEmail());
            preparedStatement.setString(2, shaPassword);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int userId = resultSet.getInt("IdKorisnika");
                int tipId = resultSet.getInt("IdTipKorisnika");
                String ime = resultSet.getString("Ime");
                String prezime = resultSet.getString("Prezime");
                String emailUser = resultSet.getString("Email");
                String lozinka = resultSet.getString("Lozinka");
                Boolean status = resultSet.getBoolean("Status");
                user = new User(userId, tipId, ime, prezime, emailUser, lozinka, status);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return user;
    }

    @Override
    public List<Category> allCategory() {
        List<Category> allCategory = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from kategorija");
            while(resultSet.next()){
                allCategory.add(new Category(resultSet.getInt("IdKategorije"), resultSet.getString("ime"), resultSet.getString("opis")));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            this.closeStatment(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return allCategory;
    }

    @Override
    public Category addCategory(Category category) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("select * from kategorija where ime = ?");
            preparedStatement.setString(1, category.getIme());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Postoji kategorija sa ti imenom");
                return null;
            }

            preparedStatement = connection.prepareStatement("insert into kategorija(Ime, Opis) values(?, ?)", generatedColumns);
            preparedStatement.setString(1, category.getIme());
            preparedStatement.setString(2, category.getOpis());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                category.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return category;
    }

    @Override
    public Category updateCategory(Category category, Integer id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("update kategorija set Ime = ?, Opis = ? where IdKategorije = ?", generatedColumns);
            preparedStatement.setString(1, category.getIme());
            preparedStatement.setString(2, category.getOpis());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                category.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return category;
    }

    @Override
    public void deleteCategory(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("select * from vest where IdKategorije = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                System.out.println("Kategorija je dodeljena makar jednoj vesti");
                return;
            }

            preparedStatement = connection.prepareStatement("delete from kategorija where IdKategorije = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeConnection(connection);
        }
    }

    @Override
    public List<News> allNews() {
        List<News> news = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from vest order by VremeKreiranja desc");
            while(resultSet.next()){
                news.add(new News(resultSet.getInt("IdVesti"), resultSet.getInt("IdKategorije"), resultSet.getInt("IdKorisnika"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vremeKreiranja"), resultSet.getInt("brojPoseta")));
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.closeStatment(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return news;
    }

    @Override
    public News findeNews(Integer id){
        News news = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("select * from vest where IdVesti = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int idNews = resultSet.getInt("idVesti");
                int idKategorije = resultSet.getInt("idKategorije");
                int idKorisnika = resultSet.getInt("idKorisnika");
                String naslov = resultSet.getString("naslov");
                String tekst = resultSet.getString("tekst");
                Date date = resultSet.getDate("vremeKreiranja");
                int brPoseta = resultSet.getInt("brojPoseta");
                news = new News(idNews, idKategorije, idKorisnika, naslov, tekst, date, brPoseta);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return news;
    }

    @Override
    public News updateNews(News news, Integer id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("update vest set IdKategorije = ?, IdKorisnika = ?, Naslov = ?, Tekst = ?, BrojPoseta = ? where IdVesti = ?", generatedColumns);
            preparedStatement.setInt(1, news.getIdKategorije());
            preparedStatement.setInt(2, news.getIdKorisnika());
            preparedStatement.setString(3, news.getNaslov());
            preparedStatement.setString(4, news.getTekst());
            preparedStatement.setInt(5, news.getBrojPoseta());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                news.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return news;
    }

    @Override
    public News addNews(News news) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("insert into vest(IdKategorije, IdKorisnika, Naslov, Tekst, VremeKreiranja, BrojPoseta) values(?, ?, ?, ?, CURRENT_TIMESTAMP(), ?)", generatedColumns);
            preparedStatement.setInt(1, news.getIdKategorije());
            preparedStatement.setInt(2, news.getIdKorisnika());
            preparedStatement.setString(3, news.getNaslov());
            preparedStatement.setString(4, news.getTekst());
            preparedStatement.setInt(5, news.getBrojPoseta());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                news.setId(resultSet.getInt(1));
                news.setVremeKreiranja(resultSet.getDate("VremeKreiranja"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return news;
    }

    @Override
    public News deleteNews(Integer id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("delete from komentar where IdVesti = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("delete from vest where IdVesti = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeStatment(preparedStatement);
            this.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<News> searchNews(String text) {
        List<News> news = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("select * from vest where Naslov like '%' ? '%' or Tekst like '%' ? '%'");
            preparedStatement.setString(1, text);
            preparedStatement.setString(2, text);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                news.add(new News(resultSet.getInt("IdVesti"), resultSet.getInt("idKategorije"), resultSet.getInt("idKorisnika"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vremeKreiranja"), resultSet.getInt("brojPoseta")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return news;
    }

    @Override
    public List<User> allUsers() {

        List<User> users = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from korisnik");
            while(resultSet.next()){
                users.add(new User(resultSet.getInt("IdKorisnika"), resultSet.getInt("IdTipKorisnika"), resultSet.getString("Ime"), resultSet.getString("Prezime"), resultSet.getString("Email"), resultSet.getString("Lozinka"), resultSet.getBoolean("Status")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return users;
    }

    @Override
    public User addUser(User user) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            String shaPassword = DigestUtils.sha256Hex(user.getLozinka());
            preparedStatement = connection.prepareStatement("insert into korisnik(IdTipKorisnika, Ime, Prezime, Email, Lozinka, Status) values(?, ?, ?, ?, ?, ?)", generatedColumns);
            preparedStatement.setInt(1, user.getIdTipKorisnika());
            preparedStatement.setString(2, user.getIme());
            preparedStatement.setString(3, user.getPrezime());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, shaPassword);
            preparedStatement.setBoolean(6, user.isStatus());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                user.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return user;
    }

    @Override
    public User updateUser(User user, Integer id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("update korisnik set Ime = ?, Prezime = ?, Email = ?, IdTipKorisnika = ? where IdKorisnika = ?", generatedColumns);
            preparedStatement.setString(1, user.getIme());
            preparedStatement.setString(2, user.getPrezime());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getIdTipKorisnika());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                user.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return user;
    }

    @Override
    public User changeUserStatus(User user, Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("update korisnik set Status = ? where IdKorisnika = ? and IdTipKorisnika = ?", generatedColumns);
            preparedStatement.setBoolean(1, user.isStatus());
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, 2);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                user.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            this.closeStatment(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return user;
    }

    @Override
    public List<News> latestNews(){
        List<News> news = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM news.vest order by VremeKreiranja asc limit 10");
            while(resultSet.next()){
                news.add(new News(resultSet.getInt("IdVesti"), resultSet.getInt("IdKategorije"), resultSet.getInt("IdKorisnika"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vremeKreiranja"), resultSet.getInt("brojPoseta")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeStatment(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return  news;
    }

    @Override
    public List<News> mostPopular(){
        List<News> news = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM vest WHERE DATE(VremeKreiranja) >= DATE(NOW()) - INTERVAL 30 DAY");
            while(resultSet.next()){
                news.add(new News(resultSet.getInt("IdVesti"), resultSet.getInt("IdKategorije"), resultSet.getInt("IdKorisnika"), resultSet.getString("naslov"), resultSet.getString("tekst"), resultSet.getDate("vremeKreiranja"), resultSet.getInt("brojPoseta")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.closeStatment(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return  news;
    }
}
