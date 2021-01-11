import './styles.css';
import {ReactComponent as Logo} from './logo.svg';
import {ReactComponent as YouTubeIcon} from './youtube.svg';
import {ReactComponent as LinkedInIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';
function Footer(){
  return (
    <footer className="main-footer">
    App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
    <div className="footer-icons">
      <a href="" target="_new">
        <YouTubeIcon />
      </a>
      <a href="" target="_new">
        <LinkedInIcon />
      </a>
      <a href="" target="_new">
        <InstagramIcon />
      </a>
    </div>
    </footer>
  )
}
export default Footer;